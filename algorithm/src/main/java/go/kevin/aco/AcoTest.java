package go.kevin.aco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Tianrui Wang
 * @date 2022-11-03 15:00
 **/
public class AcoTest {

    private static Set<AntResult> antResultSet = new HashSet<>();

    public static void main(String[] args) {

        List<Job> jobList = generateJobs(1000);
        System.out.println(jobList);
        List<TimeSlot> timeSlots = generateTimeSlots();
        System.out.println(timeSlots);

        int antCount = 3000;
        int iteration = 3;
        for (int i = 1; i <= iteration; i++) {
            for (int ant = 1; ant <= antCount; ant++) {
                AntResult antResult = new AntResult();
                for (TimeSlot timeSlot : timeSlots) {
                    go(jobList, timeSlot, antResult);
                    if (antResult.getSalary() > 0) {
                        antResultSet.add(antResult);
                    }
                }
            }
        }

        //System.out.println(antResultSet);
        System.out.println("final result top 5:" + antResultSet.stream().sorted(Comparator.comparing(AntResult::getSalary).reversed()).limit(5).collect(Collectors.toList()));
    }

    private static AntResult go(List<Job> jobList, TimeSlot timeSlot, AntResult antResult) {
        Random random = new Random();

        // 过滤掉不符合时间要求的job
        List<Job> okList = jobList.stream().filter(job -> {
            //这里先不考虑自由安排工作时间场景, 完全按照时间范围来

            // 工作开始时间匹配 && 未选中过
            if (job.getDailyStartTime() < timeSlot.getStartTime() || antResult.getJobIds().contains(job.getId())) {
                return false;
            }

            // 跨天可用时间区间
            if (timeSlot.getEndTime() < timeSlot.getStartTime()) {
                // 跨天工作时间区间
                if (job.getDailyEndTime() < job.getDailyStartTime()) {
                    return timeSlot.getEndTime() >= job.getDailyEndTime();
                }
                // 正常工作时间区间
                return true;
            }

            // 正常可用时间区间
            // 跨天工作时间区间
            if (job.getDailyEndTime() < job.getDailyStartTime()) {
                return false;
            }
            // 正常工作时间区间
            return timeSlot.getEndTime() >= job.getDailyEndTime();
        }).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(okList)) {
            return antResult;
        }

        // 随机选择一个job
        Job job = okList.get(random.nextInt(okList.size()));
        antResult.getJobs().add(new JobTimeSlot(job.getDailyStartTime(), job.getDailyEndTime(), job.getId()));
        antResult.getJobIds().add(job.getId());

        // 增加总薪水
        if (job.getSalaryType() == 1) {
            antResult.setSalary(antResult.getSalary() + job.getSalary());
        } else {
            int salary = (job.getDailyEndTime() - job.getDailyStartTime()) / 100 * job.getSalary();
            antResult.setSalary(antResult.getSalary() + salary);
        }

        // 计算扣除 工作时间 和 通勤时间 后 是否还有富余
        // todo 这里要改成根据经纬度距离计算通勤时间
        if (job.getDailyStartTime() - timeSlot.getStartTime() > 100) {
            TimeSlot preTimeSlot = TimeSlot.builder().startTime(timeSlot.getStartTime()).endTime(job.getDailyStartTime() - 100).build();
            go(jobList, preTimeSlot, antResult);
        } else if (timeSlot.getEndTime() - job.getDailyEndTime() > 100) {
            TimeSlot afterTimeSlot = TimeSlot.builder().startTime(job.getDailyEndTime() + 100).endTime(timeSlot.getEndTime()).build();
            go(jobList, afterTimeSlot, antResult);
        }
        return antResult;
    }


    private static List<Job> generateJobs(int size) {
        if (size < 1) {
            return Collections.emptyList();
        }

        List<Job> jobList = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int salaryType = Math.random() < 0.5D ? 1 : 2;
            int salary = 0;
            int dailyStartTime = 0;
            int dailyEndTime = 0;

            if (salaryType == 1) {
                //日薪范围 = 100 - 200
                salary = random.nextInt(100) + 100;
                //工作开始时间范围 = 06:00 - 18:00
                dailyStartTime = 600 + (random.nextInt(12) * 100);
                //工作结束时间范围 = 工作开始时间 + 5-10个小时
                dailyEndTime = dailyStartTime + 500 + (random.nextInt(5) * 100);
                if (dailyEndTime >= 2400) {
                    dailyEndTime -= 2400;
                }
            } else {
                //时薪范围 = 15 - 25
                salary = random.nextInt(15) + 10;
                // 不限时间 24小时随时干的场景 暂时先不考虑
                /*if (random.nextInt(10) <= 5) {
                    // do nothing
                } else {
                    //工作开始时间范围 = 06:00 - 22:00
                    dailyStartTime = 600 + (random.nextInt(16) * 100);
                    //工作结束时间范围 = 工作开始时间 + 6-10个小时
                    dailyEndTime = dailyStartTime + 600 + (random.nextInt(4) * 100);
                }*/
                //工作开始时间范围 = 06:00 - 22:00
                dailyStartTime = 600 + (random.nextInt(16) * 100);
                //工作结束时间范围 = 工作开始时间 + 1-6个小时
                dailyEndTime = dailyStartTime + 100 + (random.nextInt(5) * 100);
                if (dailyEndTime >= 2400) {
                    dailyEndTime -= 2400;
                }
            }

            Job job = Job.builder()
                    .id(i)
                    .salaryType(salaryType)
                    .salary(salary)
                    .jobStartTime(LocalDateTime.now())
                    .jobEndTime(LocalDateTime.now().plusDays(random.nextInt(15)))
                    .dailyStartTime(dailyStartTime)
                    .dailyEndTime(dailyEndTime)
                    .build();
            jobList.add(job);
        }
        return jobList;
    }

    private static List<TimeSlot> generateTimeSlots() {
        List<TimeSlot> timeSlots = new ArrayList<>();
        /*timeSlots.add(TimeSlot.builder().startTime(800).endTime(1800).build());
        timeSlots.add(TimeSlot.builder().startTime(2000).endTime(300).build());*/
        timeSlots.add(TimeSlot.builder().startTime(800).endTime(1200).build());
        timeSlots.add(TimeSlot.builder().startTime(1300).endTime(1800).build());
        timeSlots.add(TimeSlot.builder().startTime(2000).endTime(300).build());
        return timeSlots;
    }


    @Data
    @Builder
    static class Job {

        private long id;

        private int salary;

        /**
         * 1日薪 2时薪
         */
        private int salaryType;

        private LocalDateTime jobStartTime;

        private LocalDateTime jobEndTime;

        private int dailyStartTime;

        private int dailyEndTime;

        @Override
        public String toString() {
            return "\nJob{" +
                    "id=" + id +
                    ", salary=" + salary +
                    ", salaryType=" + salaryType +
                    //", jobStartTime=" + jobStartTime +
                    //", jobEndTime=" + jobEndTime +
                    ", dailyStartTime=" + dailyStartTime +
                    ", dailyEndTime=" + dailyEndTime +
                    '}';
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class TimeSlot {
        private int startTime;
        private int endTime;
    }

    @Data
    static class JobTimeSlot extends TimeSlot {
        private long jobId;

        public JobTimeSlot(int startTime, int endTime, long jobId) {
            super(startTime, endTime);
            this.jobId = jobId;
        }

        @Override
        public String toString() {
            return "JobTimeSlot{" +
                    "startTime=" + super.startTime +
                    ", endTime=" + super.endTime +
                    ", jobId=" + jobId +
                    '}';
        }
    }

    @Data
    static class AntResult {
        private List<JobTimeSlot> jobs = new ArrayList<>();
        private List<Long> jobIds = new ArrayList<>();
        private int salary;

        @Override
        public String toString() {
            return "\nAntResult{" +
                    "jobs=" + jobs +
                    ", jobIds=" + jobIds +
                    ", salary=" + salary +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof AntResult)) {
                return false;
            }
            AntResult antResult = (AntResult) o;
            return this.getSalary() == antResult.getSalary();
            // && this.jobIds.size() == antResult.getJobIds().size() && this.jobIds.containsAll(antResult.getJobIds());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.getSalary());
        }
    }
}
