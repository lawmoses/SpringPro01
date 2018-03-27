package chap02_sensor;

import java.util.Map;

public class Monitor {

	private Map<String, Sensor> sensorMap; //sensorMap의 사이즈는 2
	private Map<String, Integer> config;
	
	public void setSensorMap(Map<String, Sensor> sensorMap) {
		this.sensorMap = sensorMap;
	}

	public void setConfig(Map<String, Integer> config) {
		this.config = config;
	}

	@Override
	public String toString() {
		return "Monitor [sensorMap=" + sensorMap + ", config=" + config + "]";
	}
	
	
	
}
