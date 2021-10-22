package observerdesign;
//Creating Observer class named CoachesObserver.

import observerdesign.Coaches;


public abstract class CoachesObserver {
    protected Coaches coaches;
    public abstract void update();
}
