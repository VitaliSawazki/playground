import java.util.ArrayList;
public class WeatherData implements Subject {
	private ArrayList observers;
	private float temp;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
	    observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
	    observers.add(0);
	}
	
    public void removeObserver(Observer o) {
        int i = observers.indexOf(0);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temp, humidity, pressure);
        }
    }
}