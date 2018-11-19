### Download csv files from https://www.kaggle.com/c/expedia-hotel-recommendations/data

### Pull the `jupyter/all-spark-notebook` image and run a container from it: 

```docker run -it --rm -p 8888:8888 jupyter/all-spark-notebook```

![Running jupyter](./img/running-jupyter.png "Running jupyter")

### Then open http://<docker-host>:8888 in your browser and copy login token from the console output after running the container:

![Login](./img/jupyter-login.png "Login")

### Upload csv files to the work directory as follows:

![Upload](./img/upload-file.png "Upload")
![Work dir](./img/files.png "Work dir")

### Open a Python 3 notebook and create a SparkSession configured for local mode (with Task#1):

![Notebook](./img/hotels-notebook.png "Notebook")

### After that it is possible to run the notebok.

### To import the notebook as .ipynb, select **Files** > **Download as...** > **Notebook (.ipynb)**

![Import the notebook](./img/import-as-ipynb.png "Import the notebook")
