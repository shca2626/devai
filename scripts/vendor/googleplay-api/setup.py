from setuptools import setup
from setuptools.command.build_py import build_py as _build


import os.path
import subprocess
import shutil

PROTOC_EXEC = "protoc"

CURRENT_DIR = os.path.abspath( os.path.dirname( __file__ ) )

class ProtobufBuilder(_build):

    def run(self):
        # regenerate the pb2 only when protoc exists; the vendored source
        # already ships a generated googleplay_pb2.py (grpc_tools protoc),
        # so a missing protoc is not fatal — devai patch, no upstream raise
        exec_path = shutil.which(PROTOC_EXEC)
        if exec_path is not None:
            print("Building protobuf file")
            subprocess.run([exec_path,
                "--proto_path=" + CURRENT_DIR,
                "--python_out=" + CURRENT_DIR + "/gpapi/",
                CURRENT_DIR + "/googleplay.proto"])
        else:
            print("protoc not on PATH — using the pre-generated googleplay_pb2.py shipped in this source")
        super().run()

setup(name='gpapi',
      version='0.4.4+devai.1',
      description='Unofficial python api for google play',
      url='https://github.com/NoMore201/googleplay-api',
      author='NoMore201',
      author_email='domenico.iezzi.201@gmail.com',
      license='GPL3',
      packages=['gpapi'],
      package_data={
          'gpapi': [
              'config.py'
              'device.properties',
              'googleplay_pb2.py',
              'googleplay.py',
              'utils.py'
          ]},
      include_package_data=True,
      cmdclass={'build_py': ProtobufBuilder},
      install_requires=['cryptography>=2.2',
                        'protobuf>=3.5.2',
                        'requests'])
