package com.cartridgerecycle;

/**
 * @author : sabushakya
 */
public class CartridgeRecycle {
    // Assuming max number of perks is limited to number of cartridges
    // as combination of one cartridge and perkCost
    // is required to buy a new perk.
    // Eg 7 cartridges + 14 dollars required in case of 10 cartridges, 10 dollars, 2 recycle reward and 2 perk cost.
    public int maxPerks(int cartridges, int dollar, int recycleReward, int perkCost) {
        int tempMaxPerks, max = 0;

        if (cartridges <= 0) {
            return max;
        }
        if (recycleReward <= 0) {
            tempMaxPerks = cartridges;
            return getMaxPossibleFromLowerRange(cartridges, dollar, recycleReward, perkCost, tempMaxPerks, max);
        }
        if (perkCost == 0) {
            return cartridges;
        }

        tempMaxPerks = cartridges / 2;
        while (tempMaxPerks <= cartridges) {
            if (isMaxPerksPossible(cartridges, dollar, recycleReward, perkCost, tempMaxPerks)) {
                max = tempMaxPerks;
            } else {
                break;
            }
            tempMaxPerks = tempMaxPerks + 1;
        }

        if (max == 0) {
            tempMaxPerks = (cartridges / 2) - 1;
            max = getMaxPossibleFromLowerRange(cartridges, dollar, recycleReward, perkCost, tempMaxPerks, max);
        }

        return max;
    }

    private int getMaxPossibleFromLowerRange(int cartridges,
                                             int dollar,
                                             int recycleReward,
                                             int perkCost,
                                             int tempMaxPerks,
                                             int max) {
        while (tempMaxPerks != 0) {
            if (isMaxPerksPossible(cartridges, dollar, recycleReward, perkCost, tempMaxPerks)) {
                max = tempMaxPerks;
            } else {
                break;
            }
            tempMaxPerks = tempMaxPerks - 1;
        }
        return max;
    }

    private boolean isMaxPerksPossible(int cartridges, int dollar, int recycleReward, int perkCost, int maxPerks) {
        int totalDollarRequired = maxPerks * perkCost;
        if (maxPerks <= cartridges && totalDollarRequired >= dollar) {
            int remainingCartridges = cartridges - maxPerks;
            int additionalDollarFromRecycle = recycleReward * remainingCartridges;
            if (additionalDollarFromRecycle + dollar >= totalDollarRequired) {
                return true;
            }
        }

        return false;
    }
}
