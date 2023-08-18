def call() {
    pipeline {
        agent {
            node { label 'workstation' }
        }

        stages {

            stage ('Unit-Tests') {
                steps {
                    echo 'Unit-Tests'
                    // sh 'python -m unittest'
                }
            }

            stage ('Code-Analysis') {
                steps {
                    echo 'sonar'
                    //sh 'sonar-scanner -Dsonar.host.url=http://172.31.92.0:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=payment'
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