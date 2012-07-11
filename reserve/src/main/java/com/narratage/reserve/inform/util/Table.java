package com.narratage.reserve.inform.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 기존의 HashMap은 하나의 key값을 통해서 하나의 value를 가져옵니다. 항공운항정보에서 출발공항의 값을 통해서, 도착공항의 값을
 * 통해서, 또는 시작공항과 도착공항 두개의 값을 통해서 운항정보를 가져올 수 있어야 하기 떄문에 기존의 자료구조형 Class를 사용할 수
 * 없기때문에 직접 정의하였습니다.
 * 
 * 1개의 ArrayList에서는 핵심 데이터를 저장합니다. 2개의 HashMap에서는 각각의 Row와 Column을 정의하며 내부에
 * Set<Integer> 을 활용하여 핵심데이터 ArrayList의 index값을 저장합니다.
 * 
 * 예외처리, 복잡한 메서드는 구현하지 않았습니다. 항공정보에서만 사용할 것으로 예상됩니다.
 * 
 * @author StevePak
 * 
 * @param <Row>
 *            Row값을 정합니다.
 * @param <Column>
 *            Column값을 정합니다.
 * @param <Value>
 *            Value값을 정합니다.
 */
public class Table<Row, Column, Value> {
	private ArrayList<Value> coreDataList;
	private HashMap<Row, HashSet<Integer>> rowIndexMap;
	private HashMap<Column, HashSet<Integer>> columnIndexMap;

	public Table() {
		coreDataList = new ArrayList<Value>();
		rowIndexMap = new HashMap<Row, HashSet<Integer>>();
		columnIndexMap = new HashMap<Column, HashSet<Integer>>();
	}

	public int size() {
		return coreDataList.size();
	}

	/**
	 * 데이터를 입력합니다.
	 * 
	 * @param row
	 * @param column
	 * @param value
	 */
	public void put(Row row, Column column, Value value) {
		coreDataList.add(value);

		if (rowIndexMap.containsKey(row) == false)
			rowIndexMap.put(row, new HashSet<Integer>());
		if (columnIndexMap.containsKey(column) == false)
			columnIndexMap.put(column, new HashSet<Integer>());

		rowIndexMap.get(row).add(coreDataList.size() - 1);
		columnIndexMap.get(column).add(coreDataList.size() - 1);
	}

	/**
	 * row데이터를 기준으로 값을 가져옵니다.
	 * 
	 * @param row
	 * @return
	 */
	public List<Value> getByRow(Row row) {
		return returnListGenerator(rowIndexMap.get(row));
	}

	/**
	 * column값을 기준으로 값을 가져옵니다.
	 * 
	 * @param column
	 * @return
	 */
	public List<Value> getByColumn(Column column) {
		return returnListGenerator(columnIndexMap.get(column));
	}

	/**
	 * row와 column을 둘 다 가지고있는 값을 가지고 옵니다.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Value> get(Row row, Column column) {
		Set<Integer> tmpRowSet = (Set<Integer>) rowIndexMap.get(row).clone();
		tmpRowSet.retainAll(columnIndexMap.get(column));

		return returnListGenerator(tmpRowSet);
	}

	private List<Value> returnListGenerator(Set<Integer> indexSet) {
		Integer[] indexs = indexSet.toArray(new Integer[indexSet.size()]);
		Arrays.sort(indexs);

		List<Value> returnList = new ArrayList<Value>();

		for (Integer index : indexs)
			returnList.add(coreDataList.get(index));

		return returnList;
	}
}
