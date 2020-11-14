package com.maizi.ec.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.maizi.ec.app.Latte;
import com.maizi.ec.net.callback.IRequest;
import com.maizi.ec.net.callback.ISuccess;
import com.maizi.ec.util.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * author: Maizi
 * date: 2020/11/8 13:32
 * description:
 * >>>>>>学习：AsyncTask详解
 */
public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(IRequest request, ISuccess success) {
        this.REQUEST = request;
        this.SUCCESS = success;
    }

    @Override
    protected File doInBackground(Object... params) {
        String downloaderDir = (String) params[0];
        String extension = (String) params[1];
        final ResponseBody body = (ResponseBody) params[2];
        final String name = (String) params[3];
        final InputStream is = body.byteStream();
        if (downloaderDir == null || downloaderDir.equals("")) {
            downloaderDir = "down_loads";
        }
        if (extension == null || extension.equals("")) {
            extension = "";
        }
        if (name == null) {
            return FileUtil.writeToDisk(is, downloaderDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(is, downloaderDir, name);
        }
    }

    //执行完分线程回到主线程操作
    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        autoInstallApk(file);
    }

    //处理下载的apk更新文件，直接安装
    private void autoInstallApk(File file) {
        if (FileUtil.getExtension(file.getPath()).equals("apk")) {
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(install);
        }
    }
}
