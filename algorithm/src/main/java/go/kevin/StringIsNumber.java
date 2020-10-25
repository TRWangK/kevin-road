package go.kevin;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 剑指offer-20 表示数值的字符串
 * @author Tianrui Wang
 * @date 2020-09-02 11:48
 **/
public class StringIsNumber {
	public boolean isNumber(String s) {
		if(s == null || s.length() == 0){
			return false;
		}

		Map<State, Map<CharType, State>> stateModel = generateStateModel();
		State nowState = State.STATE_START;

		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++){
			CharType charType = getCharType(charArray[i]);
			if (charType == CharType.ILLEGAL){
				return false;
			}

			Map<CharType, State> stateMap = stateModel.get(nowState);

			if(stateMap.get(charType) == null){
				return false;
			}

			nowState = stateMap.get(charType);
			continue;

		}
		return nowState == State.STATE_INTEGER ||nowState == State.STATE_POINT || nowState == State.STATE_FRACTION || nowState == State.STATE_EXP_NUMBER || nowState == State.STATE_END;

	}

	enum CharType{
		SIGN,
		INT,
		POINT,
		EXP,
		SPACE,
		ILLEGAL;
	}

	CharType getCharType(char charNow){
		if( charNow == '+' || charNow == '-' ){
			return CharType.SIGN;
		}else if ( charNow >= '0' && charNow <= '9' ){
			return CharType.INT;
		}else if ( charNow == '.' ){
			return CharType.POINT;
		}else if ( charNow == 'e' || charNow == 'E'){
			return CharType.EXP;
		}else if (charNow == ' '){
			return CharType.SPACE;
		}else {
			return CharType.ILLEGAL;
		}
	}

	enum State{
		STATE_START,
		STATE_SIGN,
		STATE_INTEGER,
		STATE_POINT,
		STATE_POINT_WITHOUT_INT,
		STATE_FRACTION,
		STATE_EXP,
		STATE_EXP_SIGN,
		STATE_EXP_NUMBER,
		STATE_END;
	}

	Map<State, Map<CharType, State>> generateStateModel(){
		Map<State, Map<CharType, State>> stateModel = new HashMap<>();

		Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
			put(CharType.SPACE, State.STATE_START);
			put(CharType.INT, State.STATE_INTEGER);
			put(CharType.POINT, State.STATE_POINT_WITHOUT_INT);
			put(CharType.SIGN, State.STATE_SIGN);
		}};
		stateModel.put(State.STATE_START, initialMap);
		Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_INTEGER);
			put(CharType.POINT, State.STATE_POINT_WITHOUT_INT);
		}};
		stateModel.put(State.STATE_SIGN, intSignMap);
		Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_INTEGER);
			put(CharType.EXP, State.STATE_EXP);
			put(CharType.POINT, State.STATE_POINT);
			put(CharType.SPACE, State.STATE_END);
		}};
		stateModel.put(State.STATE_INTEGER, integerMap);
		Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_FRACTION);
			put(CharType.EXP, State.STATE_EXP);
			put(CharType.SPACE, State.STATE_END);
		}};
		stateModel.put(State.STATE_POINT, pointMap);
		Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_FRACTION);
		}};
		stateModel.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
		Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_FRACTION);
			put(CharType.EXP, State.STATE_EXP);
			put(CharType.SPACE, State.STATE_END);
		}};
		stateModel.put(State.STATE_FRACTION, fractionMap);
		Map<CharType, State> expMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_EXP_NUMBER);
			put(CharType.SIGN, State.STATE_EXP_SIGN);
		}};
		stateModel.put(State.STATE_EXP, expMap);
		Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_EXP_NUMBER);
		}};
		stateModel.put(State.STATE_EXP_SIGN, expSignMap);
		Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
			put(CharType.INT, State.STATE_EXP_NUMBER);
			put(CharType.SPACE, State.STATE_END);
		}};
		stateModel.put(State.STATE_EXP_NUMBER, expNumberMap);
		Map<CharType, State> endMap = new HashMap<CharType, State>() {{
			put(CharType.SPACE, State.STATE_END);
		}};
		stateModel.put(State.STATE_END, endMap);

		return stateModel;
	}
}
