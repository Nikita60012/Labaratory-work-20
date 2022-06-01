interface Volt380{
    void chargeOff();
    void chargeOn();
}

interface Volt220{
    void normalChargeOff();
    void normalChargeOn();
}

public class MyProgram {
    public static void main(String[] args){
        Volt380 highVolt = new HighVoltage();
        Charge ch = new Charge(highVolt);
        ch.charging();
        VoltageAdapter adapter = new VoltageAdapter(new NormalVoltage());
        Charge charge = new Charge(adapter);
        charge.charging();
    }
}

class HighVoltage implements Volt380{

    @Override
    public void chargeOff() {
        System.out.println("Зарядка не производится");
    }

    @Override
    public void chargeOn() {
        System.out.println("Производится зарядка");
    }
}

class NormalVoltage implements Volt220{

    @Override
    public void normalChargeOff() {
        System.out.println("Зарядка с правильным напряжением не производится");
    }

    @Override
    public void normalChargeOn() {
        System.out.println("Производится зарядка с правильным напряжением");
    }
}

class VoltageAdapter implements Volt380{
    Volt220 normalVolt;
    public VoltageAdapter(Volt220 normalVolt){
        this.normalVolt = normalVolt;
    }

    @Override
    public void chargeOff() {
        normalVolt.normalChargeOff();
    }

    @Override
    public void chargeOn() {
        normalVolt.normalChargeOn();
    }
}

class Charge{
    private Volt380 high;
    public Charge(Volt380 high){
        this.high = high;
    }
    public void charging(){
        high.chargeOff();
        high.chargeOn();
    }
}

