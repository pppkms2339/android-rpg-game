package com.geek.rpg.game.actions;

import com.geek.rpg.game.Calculator;
import com.geek.rpg.game.SpecialFXType;
import com.geek.rpg.game.Unit;

public class FireballAction extends BaseAction {
    public FireballAction() {
        super("explosion64", "btnFireball");
    }

    @Override
    public boolean action(Unit me) {
        if (me.getTarget() == null) return false;
        if (me.isMyTeammate(me.getTarget())) return false;
        me.setAttackAction(1.0f);
        me.setCurrentAnimation(Unit.AnimationType.ATTACK);
        int dmg = Calculator.getFireBallDamage(me, me.getTarget());
        me.getTarget().changeHp(-dmg);
        me.getBattleScreen().getSpecialFXEmitter().setup(SpecialFXType.EXPLOSION, me, me.getTarget(), 1.0f, 2f, 2f, 0.0f, true);
        me.getBattleScreen().getSpecialFXEmitter().setup(SpecialFXType.EXPLOSION, me.getTarget(), me.getTarget(), 1.0f, 2f, 10f, 1.0f, true);
        return true;
    }
}
