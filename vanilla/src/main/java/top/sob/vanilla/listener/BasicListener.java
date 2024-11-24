package top.sob.vanilla.listener;

import com.google.common.eventbus.Subscribe;

import top.sob.core.api.Events;

import top.sob.vanilla.Initialize;
import top.sob.vanilla.util.RandomUtil;

import java.util.Objects;

public class BasicListener {

    @SuppressWarnings("unused")
    @Subscribe
    public void act(Object e) {

        var tmp = RandomUtil.requireInstanceOf(e, Events.class);

        Objects.requireNonNull(tmp);

        switch (tmp) {
            case GTInit -> Initialize.runGTInit();
            case GameLogicInit -> Initialize.runGameLogicInit();
        }
    }

}
