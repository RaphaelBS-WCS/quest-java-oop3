public class Penguin extends Bird implements Swim, Fly {

    private int altitude;
    private boolean flying;
    private boolean swimming;
    private int depths;

    public Penguin(String name) {
        super(name);
        this.swimming = false;
        this.depths = 0;
        this.flying = false;
        this.altitude = 0;
    }

    @Override
    public String sing() {
        return "Quack!";
    }

    public int getDepths() {
        return depths;
    }

    public boolean isSwimming() {
        return swimming;
    }

    public int getAltitude() {
        return altitude;
    }


    public boolean isFlying() {
        return flying;
    }

    /**
     * dives, must be on ground
     */
    @Override
    public void dive() {
        if (!this.swimming && this.depths == 0) {
            this.swimming = true;
            System.out.printf("%s dives into the water.%n", this.getName());
        }
    }

    /**
     * swim downward
     * @param meters depths increase
     * @return depth
     */
    @Override
    public int swimDown(int meters) {
        if (this.swimming) {
            this.depths = Math.min(this.depths + meters, 325);
            System.out.printf("%s swims downward, depths : %d%n", this.getName(), this.depths);
        }
        return this.depths;
    }

    /**
     * swin upward
     * @param meters depths decrease
     * @return depth
     */
    @Override
    public int swimUp(int meters) {
        if (this.swimming) {
            this.depths = Math.max(this.depths - meters, 0);
            System.out.printf("%s swims upward, depths : %d%n", this.getName(), this.depths);
        }
        return this.depths;
    }

    /**
     * get out of water, must be on surface
     */
    @Override
    public void getOut() {
        if (this.swimming && this.depths == 0) {
            System.out.printf("%s gets out of the water.%n", this.getName());
        } else {
            System.out.printf("%s is too deep, it can't get out.%n", this.getName());
        }
    }

    @Override
    public void takeOff() {
        if (!this.isFlying() && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s fly into the air.%n", this.getName());
        }
    }

    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude + meters, 0);
            System.out.printf("%s flew upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude - meters, 325);
            System.out.printf("%s flew downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void glide() {

    }

    @Override
    public void land() {
        if (this.flying && this.altitude == 0) {
            System.out.printf("%s land on earth.%n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't land.%n", this.getName());
        }
    }
}
