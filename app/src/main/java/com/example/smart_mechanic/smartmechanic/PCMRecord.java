package com.example.smart_mechanic.smartmechanic;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Phillip on 9/29/2015.
 */
public class PCMRecord extends Activity {


    AudioRecord audioRecord;
    int result = 0;
    int size = AudioRecord.getMinBufferSize(44100, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
    short audioData[] = new short[32768];
    int tempCounter = 0;

    File file = new File("recordResult.txt");

    int avgAmp[] = new int [48];
    int windowThresholds[] = new int [48];


    double[] freq = new double[32768];
    double[] amplitude = new double[32768];



    FileOutputStream fos = null;


    public void StartRecording() {

        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, 44100,
                AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,
                size);

        audioRecord.startRecording();
        Thread thread = new Thread() {

            @Override

            public void run() {
                while (audioRecord.getRecordingState() != AudioRecord.RECORDSTATE_STOPPED) {
                    result = audioRecord.read(audioData, 0, 32768);

                    if (result == AudioRecord.ERROR_INVALID_OPERATION) {
                        System.out.println("ERROR INVALID OPERATION");
                       break;
                    } else if (result == AudioRecord.ERROR_BAD_VALUE) {
                       break;
                    }
                }
            }
        };
        thread.start();



    }

    public void WriteFile() throws IOException {

      // BufferedWriter writer = new BufferedWriter(new FileWriter("recordResult.dat"));

        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "recordResult.bin");
        if(file.exists())
        {
            file.delete();
        }

        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));


        }

    public void stopRecording() {
        audioRecord.stop();
        audioRecord.release();

        System.out.println(audioData.length);
        //for (short anAudioData : audioData) System.out.println(anAudioData);




    }

    public Complex[] ComplexFFT(Complex[] fftResult) {
        //Write data to complex array

        Complex[] complexData = new Complex[32768];
        for (int i = 0; i < 32768; i++) {
            complexData[i] = new Complex(audioData[i], 0);
        }

        fftResult = FFT.fft(complexData);


        //Compute the frequencies
        for (int i = 0; i < 32768; i++) {
            freq[i] = i * 44100 / 32768;

            amplitude[i] = fftResult[i].abs();

        }

        double mag_max = amplitude[0];
        int i_max = 0;
        //Determine max amplitude using first n/2 (Nyquist limit = 22006 Hz)
        for (int i = 1; i < 16384; i++) {
            if (amplitude[i] > mag_max) {

                mag_max = amplitude[i];
                i_max = i;
            }
        }



        //Print FFT Processing results

        for(int i = 0; i<fftResult.length; i++) {



            //System.out.println("FFT Data in PCMRecord: "+ fftResult[i].toString());
            //System.out.println("Freq at " + i +": " + freq[i]);
            //System.out.println("Amplitude at " + i + ": "+ amplitude[i]);

        }

        System.out.println("Max amplitude: " + amplitude[i_max]);
        System.out.println("Frequency of max amplitude: " + freq[i_max]);


        //Calculate window thresholds
        for(double i = 5; i <=14.4; i = i+0.2){
            windowThresholds[tempCounter] = (int)(Math.pow(2,i));
            tempCounter++;
        }
        tempCounter = 0;
        double average = 0;
        int k = 0;
        //Calculate averages in each window
        for(int i = 0; i<16384; i++){
            average = amplitude[i] + average;
            k++;
            if(i == windowThresholds[tempCounter]){

                avgAmp[tempCounter] = (int)average/48;
                average = 0;
                k= 0;
                tempCounter++;


            }



        }
        tempCounter = 0;

        for(int i = 0; i < avgAmp.length; i++){
            System.out.println(avgAmp[i]);

        }











        return fftResult;



    }





}
