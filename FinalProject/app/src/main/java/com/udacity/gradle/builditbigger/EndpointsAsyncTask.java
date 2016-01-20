package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private MainActivity mainActivity;

    @Override
    protected String doInBackground(Context... params) {
        mainActivity = (MainActivity) params[0];
        int rnd = (int) (100 * Math.random());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "This is joke " + rnd;
//        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
//            // end options for devappserver
//
//            myApiService = builder.build();
//        }
//
//        context = params[0];
//
//        try {
//            return myApiService.tellJoke().execute().getData();
//        } catch (IOException e) {
//            return e.getMessage();
//        }
    }

    @Override
    protected void onPostExecute(String result) {
        mainActivity.showProgressBar(false);
        Toast.makeText(mainActivity, result, Toast.LENGTH_LONG).show();
    }
}
