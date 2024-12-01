pipeline {
    agent any // Запускается на любом доступном агенте

    environment {
        ANT_HOME = 'D:\\BSUIR\\РИС\\9lab\\apache-ant-1.10.15' // Укажите путь к Ant
        JAVA_HOME = 'C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.5.11-hotspot' // Укажите путь к JDK
        PATH = "${env.ANT_HOME}/bin:${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Клонируем репозиторий
                git url: 'https://github.com/DmitriySkurat/antEx.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Сборка проекта через Ant
                sh "${env.ANT_HOME}/bin/ant -f build.xml clean compile jar"
            }
        }

        stage('Test') {
            steps {
                // Запуск тестов (если есть тесты)
                echo 'Running tests...'
                // sh 'ant test' - закомментировано, если тесты отсутствуют
            }
        }

        stage('Package') {
            steps {
                // Проверка, собран ли JAR
                script {
                    def jarExists = fileExists 'out/something.jar'
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
                // Добавьте шаги для деплоя, если нужно
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