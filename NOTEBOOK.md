Download csv files from https://www.kaggle.com/c/expedia-hotel-recommendations/data

Pull the `jupyter/all-spark-notebook` image and run a container from it: 

```docker run -it --rm -p 8888:8888 jupyter/all-spark-notebook```

![Running jupyter](./img/running-jupyter.png "Running jupyter")

Then open http://<docker-host>:8888 in your browser and copy login token from the console output after running the container:

![Login](./img/jupyter-login.png "Login")

Open a Python 3 notebook and create a SparkSession configured for local mode:

![Notebook](./img/hotels-notebook.png "Notebook")
