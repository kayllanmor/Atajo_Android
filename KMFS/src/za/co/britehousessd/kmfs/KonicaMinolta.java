/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package za.co.britehousessd.kmfs;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebSettings.RenderPriority;


public class KonicaMinolta extends DroidGap
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
     //   super.appView.getSettings().setUseWideViewPort(true);
     //   super.appView.getSettings().setLoadWithOverviewMode(true);
        // Set by <content src="index.html" /> in config.xml
		
		//Parse.initialize(this, "xx3F9sJzxYaCSybtZBZGB4TNK2mTnkZk32Z9WRR0", "0JLfqdAW8DfxBLGLPzN7ZrBAty82drdQQLAvVDMU"); 
		//PushService.subscribe(this, "", KonicaMinolta.class);
       // super.loadUrl("file:///android_asset/www/test.html");
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.setIntegerProperty("loadUrlTimeoutValue", 60000);
        super.loadUrl(Config.getStartUrl());
        this.appView.getSettings().setRenderPriority(RenderPriority.HIGH);
        this.appView.getSettings().setPluginState(android.webkit.WebSettings.PluginState.ON_DEMAND);
        
        
   /*     
        getWindow().setFlags(
        		WindowManager.LayoutParams.FLAG_FULLSCREEN,                   
        		WindowManager.LayoutParams.FLAG_FULLSCREEN
        		);*/ 
    } 
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
        .setMessage("Do you want to exit application?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            // do something when the button is clicked
            public void onClick(DialogInterface arg0, int arg1) {

                finish();
                //close();


            }
        })
        .setNegativeButton("No", new DialogInterface.OnClickListener() {

            // do something when the button is clicked
            public void onClick(DialogInterface arg0, int arg1) {
                           }
        })
          .show();

    }
}

