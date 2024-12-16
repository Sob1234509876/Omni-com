package top.sob.vanilla.models.market.contract;

import top.sob.core.proof.Modifiable;
import top.sob.core.utils.SecurityUtils;
import top.sob.vanilla.game.gt.politic.Contract;
import top.sob.vanilla.game.gt.resource.Item;
import top.sob.vanilla.models.aMaths.DeviateEquation;
import top.sob.vanilla.models.market.Market;
import top.sob.vanilla.proof.WIPException;

import java.math.BigDecimal;
import java.util.*;

public class ContractMarket implements Market {

    private static final ContractMarket DEFAULT = new ContractMarket();

    private final Map<String, List<Contract>> marketPool = new HashMap<>();

    public static ContractMarket getInstance() {
        return DEFAULT;
    }

    @Override
    public DeviateEquation getMarketGrowthEquation(Item item) {
        throw new WIPException();
    }

    @Override
    public Item buy(String name, BigDecimal amt) {
        throw new WIPException();
    }

    @Override
    public Item sell(Item item) {
        throw new WIPException();
    }

    @Override
    public BigDecimal getValue(String item, BigDecimal amt) {
        throw new WIPException();
    }

    @Modifiable
    public Map<String, List<Contract>> getMarketPool() {

        SecurityUtils.requireNonScriptInvoker();

        return marketPool;
    }
}
