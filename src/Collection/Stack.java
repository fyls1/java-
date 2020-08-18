package Collection;

import charactor.kHero;

public interface Stack {

    //把英雄推入到最后位置
    public void push(kHero h);
    //把最后一个英雄取出来
    public kHero pull();
    //查看最后一个英雄
    public kHero peek();
}
