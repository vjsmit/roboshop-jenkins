def call() {
    pipeline {
        agent {
            node { label 'workstation' }
        }

        stages {

            stage ('Build') {
                steps {
                    sh 'go mod init dispatch'
                    sh 'go get'
                    sh 'go build'
                }
            }

            stage ('Unit-Tests') {
                steps {
                    echo 'sonar'
                    //sh 'sonar-scanner -Dsonar.host.url=http://172.31.92.0:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=dispatch'
                }
            }

            stage ('Code-Analysis') {
                steps {
                    echo 'Code-Analysis'
                }
            }

            stage ('Security Checks') {
                steps {
                    echo 'Security Checks'
                }
            }

            stage ('Publish Artifact') {
                steps {
                    echo 'Publish Artifact'
                }
            }
        }
    }
}