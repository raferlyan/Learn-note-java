package com.raferl.test.javacv;

import com.raferl.test.javacv.dto.SynthesisDto;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * @author raferlyan
 * @date 2022/9/4 18:57
 **/
public class JavaCvTest {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        try(FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/Users/raferlyan/Downloads/video.mp4", 640, 480);
            Java2DFrameConverter converter = new Java2DFrameConverter()){
            //设置视频编码层模式
            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
            //设置视频为1帧每秒
            recorder.setFrameRate(1);
            //设置视频图像数据格式
            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
            recorder.setFormat("mp4");

            java.io.File file = new java.io.File("/Users/raferlyan/Documents/WallPaper/Other");
            java.io.File[] fileList = file.listFiles();
            recorder.start();
            for (java.io.File value : fileList) {
                BufferedImage read = ImageIO.read(value);
                recorder.record(converter.getFrame(read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
