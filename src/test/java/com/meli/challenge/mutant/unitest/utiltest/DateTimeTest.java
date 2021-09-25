package com.meli.challenge.mutant.unitest.utiltest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import org.junit.Test;

import com.meli.challenge.mutant.util.DateFormatType;
import com.meli.challenge.mutant.util.DateTime;

public class DateTimeTest {
	
	@Test
	public void convertToDate() {
		LocalDate date = DateTime.convertToDate("2018-06-20");
		assertThat(date.getYear()).isEqualTo(2018);
		assertThat(date.getMonthValue()).isEqualTo(6);
		assertThat(date.getDayOfMonth()).isEqualTo(20);	
	}
	
	@Test
	public void convertToDateUsingInvalidFormat() {
		Throwable thrown = catchThrowable(() -> { DateTime.convertToDate("06-2018-20");});
		assertThat(thrown).isInstanceOf(DateTimeParseException.class);     
	}
	
	@Test
	public void convertToDateTime() {
		LocalDateTime dateTime = DateTime.convertToDateTime("2018-06-20T23:10:15");
		assertThat(dateTime.getYear()).isEqualTo(2018);
		assertThat(dateTime.getMonthValue()).isEqualTo(6);
		assertThat(dateTime.getDayOfMonth()).isEqualTo(20);	
		assertThat(dateTime.getHour()).isEqualTo(23);
		assertThat(dateTime.getMinute()).isEqualTo(10);
		assertThat(dateTime.getSecond()).isEqualTo(15);
	}
	
	@Test
	public void convertToDateTimeUsingInvalidFormat() {
		Throwable thrown = catchThrowable(() -> { DateTime.convertToDateTime("06-2018-20");});
		assertThat(thrown).isInstanceOf(DateTimeParseException.class);     
	}
	
	@Test 
	public void getActualDate() {
		String date = DateTime.now(DateFormatType.DATE);
		assertThat(date).isNotEmpty();
	}
	
	@Test
	public void getActualDateTime()
	{
		String date = DateTime.now(DateFormatType.DATETIME);
		assertThat(date).isNotEmpty();
	}
	
}
