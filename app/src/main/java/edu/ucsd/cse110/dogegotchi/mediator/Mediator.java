package edu.ucsd.cse110.dogegotchi.mediator;

import android.view.View;

import edu.ucsd.cse110.dogegotchi.doge.Doge;
import edu.ucsd.cse110.dogegotchi.doge.IDogeObserver;

public class Mediator implements IDogeObserver {
    Doge doge;
    View foodMenu;

    public Mediator(Doge doge, View foodMenu) {
        this.doge = doge;
        this.foodMenu = foodMenu;
        this.doge.register(this);
    }

    @Override
    public void onStateChange(Doge.State newState) {
        if (newState == Doge.State.SAD) {
            this.foodMenu.setVisibility(View.VISIBLE);
            this.foodMenu.bringToFront();
        }
        else if (newState == Doge.State.EATING) {
            this.foodMenu.setVisibility(View.GONE);
        }
    }
    public void dogEat() {
        this.doge.doEat();
    }
}
