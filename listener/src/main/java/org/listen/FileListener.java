package org.listen;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.logging.Logger;

public class FileListener extends FileAlterationListenerAdaptor {
    private Logger log = Logger.getLogger(String.valueOf(FileListener.class));

    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
        log.info("[改变目录：]"+ directory.getAbsolutePath());
    }

    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
        log.info("[创建目录：]"+ directory.getAbsolutePath());
    }

    @Override
    public void onDirectoryDelete(File directory) {
        super.onDirectoryDelete(directory);
        log.info("[删除目录：]"+ directory.getAbsolutePath());
    }

    @Override
    public void onFileChange(File file) {
        super.onFileChange(file);
        log.info("[修改文件：]" + file.getAbsolutePath());
    }

    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
        log.info("[创建文件：]" + file.getAbsolutePath());
    }

    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);
        log.info("[删除文件：]" + file.getAbsolutePath());
    }

    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
    }
}
