package com.yur.demo.pattern.DynamicProxy;

public class ActorInstance implements Actor {

    /**
     * 跳舞
     */
    @Override
    public void dance() {
        System.out.println("跳了一段舞。。。");
    }

    /**
     * 唱歌
     */
    @Override
    public void sing() {
        System.out.println("唱了一首歌。。。");
    }



    public static void main(String[] args){
        Actor actor = (Actor) new MyInvocationHandler().getInstance(new ActorInstance());
        actor.sing();
        actor.dance();
    }
}
