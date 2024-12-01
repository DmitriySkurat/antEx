pipeline {
    agent any // Запускается на любом доступном агенте

    environment {
        ANT_HOME = 'D:\\BSUIR\\РИС\\9lab\\apache-ant-1.10.15' // Укажите путь к Ant
        JAVA_HOME = 'C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.5.11-hotspot' // Укажите путь к JDK
        PATH = "${ANT_HOME}\\bin;${JAVA_HOME}\\bin;${env.PATH}" // Windows использует ";" для разделения путей
    }

    stages {
        stage('Checkout') {
            steps {
                // Клонируем репозиторий
                git url: 'https://github.com/DmitriySkurat/antEx.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                // Сборка проекта через Ant
                bat "\"${env.ANT_HOME}\\bin\\ant\" -f build.xml clean compile jar"
            }
        }

        stage('Test') {
            steps {
                // Запуск тестов (если есть тесты)
                echo 'Running tests...'
                // bat 'ant test' - закомментировано, если тесты отсутствуют
            }
        }

        stage('Package') {
            steps {
                // Проверка, собран ли JAR
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
