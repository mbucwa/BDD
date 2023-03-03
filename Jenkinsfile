node('master'){
stage('SCM Checkout'){
    git 'https://github.com/mbucwa/BDD'
}
stage('Build'){
def mvnHome = tool name: 'M2_HOME', type: 'maven'
sh "${mvnHome}"/bin/mvn clean test"
}

}