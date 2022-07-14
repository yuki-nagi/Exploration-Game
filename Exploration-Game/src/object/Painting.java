package object;

public class Painting extends GameObject {

    @Override
    public void mebosiEvent() {
        System.out.println("この部屋で一際存在感を放つ絵画だ。");
        System.out.println("作者は「Caesar」(シーザー)で、タイトルは「Wanry」のようだ。");
        if(this.isLookChecked() == false){
            System.out.println("「Wanry」は人名なのか？ どう読むのだろうか。");
        }
        else if(this.isLookChecked() == true){
            System.out.println("「Wanry」は絵に描かれた彼女の名なのだろうか。しかし人名にしてはどう読むのか見当がつかないな。"); 
        }
        this.setMebosiChecked(true);
    }

    @Override
    public void breakEvent() {
        System.out.println("絵画を壊すなんてとんでもない。");
        System.out.println("この絵にかけられた労力も、この絵につけられるべき価値も自分には分からないが、少なくとも敬意を払うべき芸術作品だと感じた。");
    }

    @Override
    public void lookEvent() {
        System.out.println("天から階段を降りて地上に歩みを進める女性の絵だ。");
        System.out.println("背から生えた翼は朽ちかけているが、地上の人々に向ける表情は笑顔だ。");
        System.out.println("");
        if(this.isMebosiChecked() == false){
            System.out.println("細かく見れば、階段の段数は13段……。13段下って彼女は人間になった……そういう絵なのだろうか。");
        }
        else if(this.isMebosiChecked() == true){
            System.out.println("細かく見れば、階段の段数は13段……。13段下って「Wanry」は人間になった……そういう絵なのだろうか。");
        }
        this.setLookChecked(true);
    }

}