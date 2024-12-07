package top.sob.vanilla.models.market;

import top.sob.vanilla.utils.misc.Builder;

public interface MarketProvider {

    Builder<Market> forBuilderName(String s);

}
