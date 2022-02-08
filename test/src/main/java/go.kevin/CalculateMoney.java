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

		int age = 27;
		int base = 150000;

		Map<Integer, Integer> investAmountMapByYear = new TreeMap<Integer, Integer>();
		investAmountMapByYear.put(2022, 250000);
		investAmountMapByYear.put(2023, 300000);
		investAmountMapByYear.put(2024, 100000);
		investAmountMapByYear.put(2025, 100000);
		investAmountMapByYear.put(2026, 100000);
		investAmountMapByYear.put(2027, 150000);
		investAmountMapByYear.put(2028, 150000);
		investAmountMapByYear.put(2029, 150000);
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
		investAmountMapByYear.put(2045, 0);
		investAmountMapByYear.put(2046, -100000);
		investAmountMapByYear.put(2047, -100000);
		investAmountMapByYear.put(2048, -100000);
		investAmountMapByYear.put(2049, -100000);
		investAmountMapByYear.put(2050, -100000);
		investAmountMapByYear.put(2051, -200000);
		investAmountMapByYear.put(2052, -200000);
		investAmountMapByYear.put(2053, -200000);
		investAmountMapByYear.put(2054, -200000);
		investAmountMapByYear.put(2055, -200000);

		double profitRatio = 0.1D;

		int housePrice = 1500000;
		int marriagePrice = 120000;

		calculate(age, base, investAmountMapByYear, profitRatio, housePrice, marriagePrice);
	}

	/**
	 *
	 * @param age 年龄
	 * @param base 初始资金
	 * @param investAmountMapByYear 每年投资金额map
	 * @param profitRatio 平均年化收益率
	 * @param housePrice 房子总价
	 * @param marriagePrice 结婚花销
	 */
	public static void calculate(int age, int base , Map<Integer, Integer> investAmountMapByYear,
								 double profitRatio, int housePrice, int marriagePrice){

		double total = base;
		double houseDownPrice = housePrice * 0.35D;
		int houseLoan = 0;

		for (Map.Entry<Integer, Integer> entry : investAmountMapByYear.entrySet()){
			age++;
			int year = entry.getKey();
			int investAmount = entry.getValue() - houseLoan;


			double profit = (total + (investAmount / 2D)) * profitRatio;
			total = total + investAmount + profit;
			System.out.println(StringUtils.join(year, "年: 年底", age, "岁, 年终总金额: ", (int)total, ", 新投资金额: ", investAmount, ", 收益: ", (int)profit));

			// 买房事件
			if (age >= 30 && total > houseDownPrice && houseLoan == 0){
				total -= houseDownPrice;
				houseLoan += houseDownPrice * 0.01 * 12;
				System.out.println(StringUtils.join("--- 买房, 首付扣除本金: ", houseDownPrice, ", 余额: ", (int)total, ", 每年扣除投资金额: ", houseLoan));
			}

			// 结婚事件
			if (age == 29){
				total -= marriagePrice;
				System.out.println(StringUtils.join("--- 结婚, 扣除本金: ", marriagePrice, ", 余额: ", (int)total));
			}

		}
	}
}
