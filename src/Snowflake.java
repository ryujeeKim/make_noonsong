import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Snowflake {
    public static int stage = 3; //디폴트 값 여기에 세팅해주세요. 0,1,2,3
    public static String[] stages;
    public static ImageIcon currentImg;
    public static JLabel lbl = new JLabel();
    public static Image img;
    static BufferedImage buffered;


    //현재 레벨 상태의 이미지 출력
    public Snowflake() {
        //stage = 1; 
        stages = new String[]{
                "images/noonsong_level0.png",
                "images/noonsong_level1.png",
                "images/noonsong_level2.png",
                "images/noonsong_level3.png",
                "images/noonsong_level4.png"
        };

    }


    // stage에 해당하는 bufferedImage를 반환하는 메서드
    public BufferedImage getCurrentStageIcon() {
        try{
            buffered= ImageIO.read(new File(stages[stage]));
        }catch(IOException e){
            System.out.println("파일이 없거나 경로가 잘못 지정되었습니다.");
            e.printStackTrace();
        }
        return buffered;
    }

    public int getStage() {
        return stage;
    }

    //박사 단계의 문제까지 모두 맞췄을 때
    //swing 등 효과 추가.
    public static void finalNunsong() {
        JOptionPane.showMessageDialog(null, "축하합니다! 만렙 달성!!!");
        System.out.println("만렙 달성 !");
    }

    // stage를 증가시키는 메서드
    public static void evolve() {
        if (stage < stages.length - 1) {
            stage++;
        }
        if (stage == stages.length - 1) {
            finalNunsong();
        }        
    }

    // stage를 초기화하는 메서드
    public void reset() {
        stage = 0;
    }

    public static void main(String[] args) {

        Snowflake snowflake = new Snowflake();

    }
}




