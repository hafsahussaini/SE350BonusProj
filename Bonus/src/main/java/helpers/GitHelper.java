package helpers;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
    This is where we work with the actual git repo.
    It can be used as a helper class for other parts of the project
    that need to interact with a Git repo
    like maybe a tool for analyzing code quality or generating reports
*/
public class GitHelper {

    private Git git;

    // Constructor will take a path to a local Git repository and
    // initialize a new Git object to use to work with that repository
    public GitHelper(String localPath) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        git = new Git(builder.setGitDir(new File(localPath + "/.git")).readEnvironment().findGitDir().build());
    }

    // Cloning Git repo from a remote URL to local directory
    public void cloneRepository(String gitRepoUrl) throws GitAPIException {
        Git.cloneRepository()
                .setURI(gitRepoUrl)
                .setDirectory(new File("."))
                .call();
    }

    // Retrieving a list of all Java files in the Git repo by iterating through
    // all branches, commits in ea. branch, and all files in each commit,
    // filtering only the files with .java extension
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
