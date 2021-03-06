package com.demonwav.ectotokens.action;

import com.demonwav.ectotokens.EctoTokens;
import com.demonwav.ectotokens.config.shop.actions.ApplyEffectsActionConfig;
import com.demonwav.ectotokens.gui.Window;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ApplyEffectsAction extends Action {

    private final ApplyEffectsActionConfig config;

    public ApplyEffectsAction(ApplyEffectsActionConfig config) {
        this.config = config;
    }

    @Override
    public void run(Window window, Player player, EctoTokens plugin) {
        for (ApplyEffectsActionConfig.Effect effect : config.getEffects()) {
            PotionEffectType type = PotionEffectType.getByName(effect.getEffect());
            int duration = 0;
            for (PotionEffect potions : player.getActivePotionEffects()) {
                if (potions.getType() == type) {
                    if (potions.getAmplifier() == effect.getAmplifier()) {
                        duration = potions.getDuration();
                    }
                    player.removePotionEffect(potions.getType());
                }
            }
            player.addPotionEffect(new PotionEffect(type, effect.getDuration() + duration, effect.getAmplifier(), effect.getAmbient(), effect.getParticles()));
        }
        window.updateInformation();
    }
}
