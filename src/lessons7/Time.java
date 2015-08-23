package lessons7;

public class Time {
	// Ex16

	private int seconds;
	private int minutes;
	private int hours;

	public Time(int seconds, int minutes, int hours) {
		if (seconds <= 59 && seconds >= 0) {
			this.seconds = seconds;
		} else {
			System.out.println("Ошибка записи секунд");
		}
		if (minutes <= 59 && minutes >= 0) {
			this.minutes = minutes;
		} else {
			System.out.println("Ошибка записи минут");
		}
		if (hours <= 23 && hours >= 0) {
			this.hours = hours;
		} else {
			System.out.println("Ошибка записи часов");
		}
	}

	public Time(int allSeconds) {
		int sec = allSeconds % 60;
		this.seconds = sec;
		int m = (allSeconds - sec) / 60;
		int min = m % 60;
		this.minutes = min;
		int h = (m - min) / 60;
		int hour = h % 24;
		this.hours = hour;
	}

	public int getAllSeconds() {
		int allSeconds = (hours * 3600) + (minutes * 60) + seconds;
		return allSeconds;
	}

	public int compareTime(Time time2) {
		int allSecondsTime1 = (hours * 3600) + (minutes * 60) + seconds;
		int allSecondsTime2 = (time2.hours * 3600) + (time2.minutes * 60)
				+ time2.seconds;
		int result = -101;
		if (allSecondsTime1 > allSecondsTime2) {
			result = 1;
		} else if (allSecondsTime1 < allSecondsTime2) {
			result = -1;
		} else if (allSecondsTime1 == allSecondsTime2) {
			result = 0;
		}
		return result;
	}

	public int getSeconds() {
		return seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getHours() {
		return hours;
	}

	public String toString() {
		return "Time [seconds=" + seconds + ", minutes=" + minutes + ", hours="
				+ hours + "]";
	}
}
