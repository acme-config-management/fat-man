# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
    config.vm.box = "ubuntu/xenial64"
    config.vm.network "forwarded_port", guest: 9876, host: 8080

    config.vm.provider "virtualbox" do |vb|
        vb.memory = "2048"
    end

    config.vm.provision "shell", privileged: true, inline: <<-SHELL
        apt-get update
    SHELL

#    config.vm.provision "shell", privileged: true, inline: <<-SHELL
#        add-apt-repository ppa:webupd8team/java
#        apt-get update
#        echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
#        apt-get -y install oracle-java8-set-default
#        sudo ln -s /usr/lib/jvm/java-8-oracle /usr/lib/jvm/default-java
#    SHELL

    config.vm.provision "shell", privileged: true, inline: <<-SHELL
        add-apt-repository ppa:cwchien/gradle
        apt-get update
        apt-get -y install gradle
        echo cd /vagrant >> .bashrc
    SHELL

    config.vm.provision "shell", privileged: true, inline: <<-SHELL
        apt-get install -y postgresql postgresql-contrib
        sudo -u postgres createuser ubuntu -l -r -s -w -d
        sudo -u postgres createdb ubuntu
    SHELL

    config.vm.provision "shell", privileged: false, inline: <<-SHELL
        psql -c "CREATE USER my_user WITH PASSWORD 'my_password';"
    SHELL

    config.vm.provision "shell", privileged: false, inline: <<-SHELL
        echo "export db_ip=localhost" >> ~/.profile
        echo "export db_port=5432" >> ~/.profile
        echo "export db_name=ubuntu" >> ~/.profile
        echo "export db_user=my_user" >> ~/.profile
        echo "export db_pass=my_password" >> ~/.profile
    SHELL

end