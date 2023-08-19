def call() {

    node ('workstation') {

            if (env.cibuild == "java") {

                stage ('Build') {
                        sh 'mvn package'
                }
            }

            stage ('Unit-Tests') {
                    echo 'Unit-Tests'
            }

            stage ('Code-Analysis') {
                    echo 'sonar'
                    //sh 'sonar-scanner -Dsonar.host.url=http://172.31.92.0:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=frontend -Dsonar.qualitygate.wait=true'
            }

            stage ('Security Checks') {
                    echo 'Security Checks'
            }

            if (env.TAG_NAME ==~ ".*") {

                stage ('Publish Artifact') {
                    echo 'Publish Artifact'
                }
            }
    }
}