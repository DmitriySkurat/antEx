pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.5.11-hotspot'
        ANT_HOME = 'D:\\BSUIR\\РИС\\9lab\\apache-ant-1.10.15'
        PATH = "${ANT_HOME}\\bin;${JAVA_HOME}\\bin;${env.PATH}"
    }

    tools {
        ant 'Apache Ant 1.10.15' // Reference to a configured Ant tool
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/DmitriySkurat/antEx.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Using Ant from: ${env.ANT_HOME}"
                    bat "ant -f build.xml clean compile jar"
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }

        stage('Package') {
            steps {
                script {
                    def jarExists = fileExists('out/something.jar')
                    if (!jarExists) {
                        error("JAR file not found!")
                    }
                }
                echo "JAR file successfully built."
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy stage (optional)..."
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
