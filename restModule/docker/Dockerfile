FROM maven:3.6.3-jdk-11-slim

COPY docker/entrypoint.sh /usr/local/bin/entrypoint.sh
RUN apt-get update
RUN apt-get install -y dos2unix /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

RUN mvn install

WORKDIR /usr/src/mymaven
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["bash"]