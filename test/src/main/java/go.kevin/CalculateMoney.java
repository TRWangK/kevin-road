package go.kevin;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Tianrui Wang
 * @date 2021-01-24 17:15
 **/
public class CalculateMoney {
    public static void main(String[] args) {

        int age = 28;
        int base = 270000;

        Map<Integer, Integer> investAmountMapByYear = new TreeMap<Integer, Integer>();
        getIncome(investAmountMapByYear, true);

        double profitRatio = 0.1D;

        int housePrice = 1500000;
        int marriagePrice = 120000;

        calculate(age, base, investAmountMapByYear, profitRatio, housePrice, marriagePrice);
    }

    /**
     * @param age                   年龄
     * @param base                  初始资金
     * @param investAmountMapByYear 每年投资金额map
     * @param profitRatio           平均年化收益率
     * @param housePrice            房子总价
     * @param marriagePrice         结婚花销
     */
    public static void calculate(int age,
                                 int base,
                                 Map<Integer, Integer> investAmountMapByYear,
                                 double profitRatio,
                                 int housePrice,
                                 int marriagePrice) {

        double total = base;
        double houseDownPrice = housePrice * 0.35D;
        int houseLoan = 0;

        for (Map.Entry<Integer, Integer> entry : investAmountMapByYear.entrySet()) {
            age++;
            int year = entry.getKey();
            int investAmount = entry.getValue() - houseLoan;


            double profit = (total + (investAmount / 2D)) * profitRatio;
            total = total + investAmount + profit;
            System.out.println(StringUtils.join(year, "年: 年底", age, "岁, 年终总金额: ", (int) total, ", 新投资金额: ", investAmount, ", 收益: ", (int) profit));

            // 买房事件
            if (age >= 30 && total > houseDownPrice && houseLoan == 0) {
                total -= houseDownPrice;
                houseLoan += houseDownPrice * 0.01 * 12;
                System.out.println(StringUtils.join("--- 买房, 首付扣除本金: ", houseDownPrice, ", 余额: ", (int) total, ", 每年扣除投资金额: ", houseLoan));
            }

            // 结婚事件
            if (age == 29) {
                total -= marriagePrice;
                System.out.println(StringUtils.join("--- 结婚, 扣除本金: ", marriagePrice, ", 余额: ", (int) total));
            }

        }
    }

    private static void getIncome(Map<Integer, Integer> investAmountMapByYear, boolean beijing) {
        if (beijing) {
            investAmountMapByYear.put(2023, 250000);
            investAmountMapByYear.put(2024, 300000);
            investAmountMapByYear.put(2025, 300000);
            investAmountMapByYear.put(2026, 400000);
            investAmountMapByYear.put(2027, 400000);
            investAmountMapByYear.put(2028, 400000);
            investAmountMapByYear.put(2029, 400000);
            investAmountMapByYear.put(2030, 150000);
            investAmountMapByYear.put(2031, 150000);
            investAmountMapByYear.put(2032, 150000);
            investAmountMapByYear.put(2033, 150000);
            investAmountMapByYear.put(2034, 150000);
            investAmountMapByYear.put(2035, 100000);
            investAmountMapByYear.put(2036, 100000);
            investAmountMapByYear.put(2037, 100000);
            investAmountMapByYear.put(2038, 100000);
            investAmountMapByYear.put(2039, 100000);
            investAmountMapByYear.put(2040, 100000);
            investAmountMapByYear.put(2041, 0);
            investAmountMapByYear.put(2042, 0);
            investAmountMapByYear.put(2043, 0);
            investAmountMapByYear.put(2044, 0);
        } else {
            investAmountMapByYear.put(2023, 300000);
            investAmountMapByYear.put(2024, 350000);
            investAmountMapByYear.put(2025, 80000);
            investAmountMapByYear.put(2026, 100000);
            investAmountMapByYear.put(2027, 100000);
            investAmountMapByYear.put(2028, 150000);
            investAmountMapByYear.put(2029, 150000);
            investAmountMapByYear.put(2030, 150000);
            investAmountMapByYear.put(2031, 100000);
            investAmountMapByYear.put(2032, 100000);
            investAmountMapByYear.put(2033, 100000);
            investAmountMapByYear.put(2034, 100000);
            investAmountMapByYear.put(2035, 0);
            investAmountMapByYear.put(2036, 0);
            investAmountMapByYear.put(2037, 0);
            investAmountMapByYear.put(2038, 0);
            investAmountMapByYear.put(2039, 0);
            investAmountMapByYear.put(2040, 0);
            investAmountMapByYear.put(2041, 0);
            investAmountMapByYear.put(2042, 0);
            investAmountMapByYear.put(2043, 0);
            investAmountMapByYear.put(2044, 0);
        }
    }

    /**
     * 记录
     * 2022.02计算
     * 2024年: 年底30岁, 年终总金额: 836775
     * 2034年: 年底40岁, 年终总金额: 2028217
     * 2044年: 年底50岁, 年终总金额: 5392536
     *
     * 2022.12计算 北京路线
     * 2024年: 年底30岁, 年终总金额: 798450
     * 2034年: 年底40岁, 年终总金额: 4498543
     * 2044年: 年底50岁, 年终总金额: 11799926
     *
     * 2022.12计算 济南路线
     * 2024年: 年底30岁, 年终总金额: 908700
     * 2034年: 年底40岁, 年终总金额: 1819295
     * 2044年: 年底50岁, 年终总金额: 3664522
     */
}
