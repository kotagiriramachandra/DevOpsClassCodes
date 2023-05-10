def buildApp() {
            echo "Before ${params.BRANCH_NM}"
	    checkout scmGit(branches: [[name: "*/${params.BRANCH_NM}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'git-cred', name: 'origin', url: 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git']])
            echo "After ${params.BRANCH_NM}"
	    echo "Git pull from ${params.BRANCH_NM}"
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
