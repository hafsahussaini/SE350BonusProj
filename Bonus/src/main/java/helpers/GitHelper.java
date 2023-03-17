package main.java;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GitHelper {

    private Git git;

    public GitHelper(String localPath) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        git = new Git(builder.setGitDir(new File(localPath + "/.git")).readEnvironment().findGitDir().build());
    }

    public void cloneRepository(String gitRepoUrl) throws GitAPIException {
        Git.cloneRepository()
                .setURI(gitRepoUrl)
                .setDirectory(new File("."))
                .call();
    }

    public List<String> getJavaFiles() throws GitAPIException {
        List<String> javaFiles = new ArrayList<>();
        Iterable<Ref> branches = git.branchList().call();
        for (Ref branch : branches) {
            Iterable<ObjectId> objectIds = git.log().add(branch.getObjectId()).call().asIterable();
            for (ObjectId objectId : objectIds) {
                List<String> files = git.show().setFormat("%n").setnameOnly(true).setObjectId(objectId).call();
                for (String file : files) {
                    if (file.endsWith(".java")) {
                        javaFiles.add(file);
                    }
                }
            }
        }
        return javaFiles;
    }
}
