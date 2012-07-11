package com.test.reserve.inform.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.narratage.reserve.inform.util.Table;

public class TableTest {
	Table<Integer, Integer, String> table;

	@Before
	public void setup() {
		table = new Table<Integer, Integer, String>();
	}

	@Test
	public void put() {
		assertThat(table.size(), is(0));
		table.put(1, 1, "Test1");
		assertThat(table.size(), is(1));
		table.put(1, 2, "Test2");
		assertThat(table.size(), is(2));
	}

	@Test
	public void getByRow() {
		table.put(1, 1, "Test1");
		table.put(1, 2, "Test2");
		table.put(2, 1, "Test3");

		List<String> list = table.getByRow(1);

		assertThat(2, is(list.size()));
		assertThat(true, is(list.contains("Test1")));
		assertThat(true, is(list.contains("Test2")));
		assertThat(false, is(list.contains("Test3")));
	}

	@Test
	public void getByColumn() {
		table.put(1, 1, "Test1");
		table.put(1, 2, "Test2");
		table.put(2, 1, "Test3");

		List<String> list = table.getByColumn(1);

		assertThat(2, is(list.size()));
		assertThat(true, is(list.contains("Test1")));
		assertThat(false, is(list.contains("Test2")));
		assertThat(true, is(list.contains("Test3")));
	}

	@Test
	public void get() {
		table.put(1, 1, "Test1");
		table.put(1, 2, "Test2");
		table.put(2, 1, "Test3");
		table.put(1, 1, "Test4");

		List<String> list = table.get(1, 1);

		assertThat(2, is(list.size()));
		assertThat(true, is(list.contains("Test1")));
		assertThat(false, is(list.contains("Test2")));
		assertThat(false, is(list.contains("Test3")));
		assertThat(true, is(list.contains("Test4")));
	}

}
