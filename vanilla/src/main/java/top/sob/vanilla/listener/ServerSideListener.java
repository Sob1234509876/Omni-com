package top.sob.vanilla.listener;

import com.google.common.eventbus.Subscribe;

import top.sob.vanilla.api.game.trans.OperationElement;
import top.sob.vanilla.event.ServerEvent;
import top.sob.vanilla.util.GameBaseProvider;
import top.sob.vanilla.util.RandomUtil;

@SuppressWarnings("unused")
public class ServerSideListener {

    @SuppressWarnings("unused")
    @Subscribe
    public void act(Object e) {

        var event = RandomUtil.requireInstanceOf(e, ServerEvent.class);

        // TODO: Finish this !!!!!!

        GameBaseProvider.getDefaultProvider()
                .getLogic()
                .actToOperation(
                        RandomUtil.requireInstanceOf(
                                event.getBody(),
                                OperationElement[].class)
                );

    }

}