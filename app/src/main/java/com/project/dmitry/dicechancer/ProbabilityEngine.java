package com.project.dmitry.dicechancer;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by nucur on 8/17/2017.
 */

public class ProbabilityEngine {

    int result;

    double[] n1d, n2d, n3d, n4d, n5d;

    public ProbabilityEngine(){

        n1d = new double[6];
        n2d = new double[11];
        n3d = new double[16];
        n4d = new double[21];
        n5d = new double[26];

        loadData();
    }


    //return array of doubles with chances to hit target number or 1,2,3,4,5 dices
    public double[] fillNormal(int target){
        double[] resultArray = new double[5];

        //n1d
        if(target <= 1)
            resultArray[0] = 100;
        else if(target > 6)
            resultArray[0] = 0;
        else{
            double cumulative = 0;
            for(int i = n1d.length-1; i >= target-1;i--)
                cumulative += n1d[i];
            resultArray[0] = cumulative * 100;
        }

        //n2d
        if(target <= 2)
            resultArray[1] = 100;
        else if(target > 12)
            resultArray[1] = 0;
        else{
            double cumulative = 0;
            for(int i = n2d.length - 1; i >= target - 2; i--)
                cumulative += n2d[i];
            resultArray[1] = cumulative * 100;
        }

        //n3d
        if(target <= 3)
            resultArray[2] = 100;
        else if(target > 18)
            resultArray[2] = 0;
        else{
            double cumulative = 0;
            for(int i = n3d.length - 1; i >= target - 3; i--)
                cumulative += n3d[i];
            resultArray[2] = cumulative * 100;
        }

        //n4d
        if(target <= 4)
            resultArray[3] = 100;
        else if(target > 24)
            resultArray[3] = 0;
        else{
            double cumulative = 0;
            for(int i = n4d.length - 1; i >= target - 4; i--)
                cumulative += n4d[i];
            resultArray[3] = cumulative * 100;
        }

        //n5d
        if(target <= 5)
            resultArray[4] = 100;
        else if(target > 30)
            resultArray[4] = 0;
        else{
            double cumulative = 0;
            for(int i = n5d.length - 1; i >= target - 5; i--)
                cumulative += n5d[i];
            resultArray[4] = cumulative * 100;
        }

        return resultArray;
    }

    private void loadData(){
        //normal 1 die
        n1d[0] = 0.167;
        n1d[1] = 0.167;
        n1d[2] = 0.167;
        n1d[3] = 0.167;
        n1d[4] = 0.167;
        n1d[5] = 0.167;

        //normal 2 dices
        n2d[0] = 0.028;
        n2d[1] = 0.056;
        n2d[2] = 0.083;
        n2d[3] = 0.111;
        n2d[4] = 0.139;
        n2d[5] = 0.167;
        n2d[6] = 0.139;
        n2d[7] = 0.111;
        n2d[8] = 0.083;
        n2d[9] = 0.056;
        n2d[10] = 0.028;

        //normal 3 dices
        n3d[0] = 0.005;
        n3d[1] = 0.014;
        n3d[2] = 0.028;
        n3d[3] = 0.046;
        n3d[4] = 0.069;
        n3d[5] = 0.097;
        n3d[6] = 0.116;
        n3d[7] = 0.125;
        n3d[8] = 0.125;
        n3d[9] = 0.116;
        n3d[10] = 0.097;
        n3d[11] = 0.069;
        n3d[12] = 0.046;
        n3d[13] = 0.028;
        n3d[14] = 0.014;
        n3d[15] = 0.005;

        //normal 4 dices
        n4d[0] = 0.001;
        n4d[1] = 0.003;
        n4d[2] = 0.008;
        n4d[3] = 0.015;
        n4d[4] = 0.027;
        n4d[5] = 0.043;
        n4d[6] = 0.062;
        n4d[7] = 0.080;
        n4d[8] = 0.096;
        n4d[9] = 0.108;
        n4d[10] = 0.113;
        n4d[11] = 0.108;
        n4d[12] = 0.096;
        n4d[13] = 0.080;
        n4d[14] = 0.062;
        n4d[15] = 0.043;
        n4d[16] = 0.027;
        n4d[17] = 0.015;
        n4d[18] = 0.008;
        n4d[19] = 0.003;
        n4d[20] = 0.001;

        //nomal 5 dices
        n5d[0] = 0.001;
        n5d[1] = 0.001;
        n5d[2] = 0.002;
        n5d[3] = 0.004;
        n5d[4] = 0.009;
        n5d[5] = 0.016;
        n5d[6] = 0.026;
        n5d[7] = 0.039;
        n5d[8] = 0.054;
        n5d[9] = 0.069;
        n5d[10] = 0.084;
        n5d[11] = 0.094;
        n5d[12] = 0.100;
        n5d[13] = 0.100;
        n5d[14] = 0.094;
        n5d[15] = 0.084;
        n5d[16] = 0.069;
        n5d[17] = 0.054;
        n5d[18] = 0.039;
        n5d[19] = 0.026;
        n5d[20] = 0.016;
        n5d[21] = 0.009;
        n5d[22] = 0.004;
        n5d[23] = 0.002;
        n5d[24] = 0.001;
        n5d[25] = 0.001;

    }
}
