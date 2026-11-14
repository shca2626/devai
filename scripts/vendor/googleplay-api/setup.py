from setuptools import setup
from setuptools.command.build_py import build_py as _build


import os.path
import subprocess
import shutil

PROTOC_EXEC = "protoc"

CURRENT_DIR = os.path.abspath( os.path.dirname( __file__ ) )

class ProtobufBuilder(_build):

    def run(self):
        # regenerate only when missing — a generated googleplay_pb2.py is
        # committed by bootstrap (grpcio-tools 1.62.x / protoc 25.x gencode,
        # matched to the protobuf<5 runtime pin). Never regenerate with an
        # arbitrary system protoc: a too-new one would emit gencode that
        # requires protobuf>=5 and break the pin.
        pb2 = os.path.join(CURRENT_DIR, 'gpapi', 'googleplay_pb2.py')
        if not os.path.exists(pb2):
            exec_path = shutil.which(PROTOC_EXEC)
            if exec_path is not None:
                print("Building protobuf file")
                subprocess.run([exec_path,
                    "--proto_path=" + CURRENT_DIR,
                    "--python_out=" + CURRENT_DIR + "/gpapi/",
                    CURRENT_DIR + "/googleplay.proto"])
            else:
                print("googleplay_pb2.py missing and no protoc — bootstrap generates it via grpcio-tools")
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
              'device.properties',
              'googleplay_pb2.py',
          ]},
      include_package_data=True,
      cmdclass={'build_py': ProtobufBuilder},
      install_requires=['cryptography>=2.2',
                        'protobuf>=3.5.2',
                        'requests'])
