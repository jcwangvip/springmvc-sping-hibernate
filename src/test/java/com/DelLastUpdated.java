package com;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
 * <p>Copyright: All Rights Reserved</p>  
 * <p>Description: 清除maven下载不完整的jar包 </p> 
 * <p>Author:aaron</p>
 */
public class DelLastUpdated {
	
    private static final Log _log = LogFactory.getLog(DelLastUpdated.class);
    private static final String MAVEN_REPO_PATH = "F:/mavenRepos";
    private static final String FILE_SUFFIX = "lastUpdated";

    /**
     * @param args
     */
    public static void main(String[] args) {
        _log.info("begin:");
        File mavenRep = new File(MAVEN_REPO_PATH);
        if (!mavenRep.exists()) {
            _log.warn("Maven repos is not exist.");
            return;
        }

        check(mavenRep);
        _log.info("end");
    }

    private static void check(File file) {
        if(file.isFile()) {
            if (file.getName().endsWith(FILE_SUFFIX)) {
                delFileRecr(file);
            }
        }else if(file.isDirectory()) {
            for(File f : file.listFiles()) {
                check(f);
            }
        }
    }

    private static void delFileRecr(File file) {
        _log.info("delete file: " + file.getName());
        file.delete();
    }
}