FROM ubuntu:latest
LABEL authors="emilianopadilla"

ENTRYPOINT ["top", "-b"]