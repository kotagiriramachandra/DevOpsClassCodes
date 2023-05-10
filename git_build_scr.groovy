def buildApp() {
            echo "Before ${params.BRANCH-NM}"
	    checkout scmGit(branches: [[name: "*/${params.BRANCH-NM}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'git-cred', name: 'origin', url: 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git']])
            echo "After ${params.BRANCH-NM}"
	    echo "Git pull from ${params.BRANCH-NM}"
}

def compileApp() {
            bat 'mvn clean compile'
	    echo 'clean compile done'
}

def testApp() {
                bat 'mvn test'
}

def qaApp() {
                bat 'mvn pmd:pmd'
}

def pkgApp() {
                bat 'mvn package'
		echo 'build done'
}

return this
