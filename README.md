# meta-video-streamer

# Build setup (RPi)
1. Create a working directory and in that a directory for meta layers e.g source
1. Clone all needed repo's in the directory of the meta layers
    ```
    git clone https://git.openembedded.org/openembedded-core
    git clone https://git.openembedded.org/meta-openembedded
    git clone https://github.com/agherzan/meta-raspberrypi.git
    git clone https://github.com/bramoosterhuis/meta-video-streamer.git
    ```
1. From the working directory do
    ```
    source source/oe-core/oe-init-build-env
    ```
1. Add needed meta layers
    ```
    bitbake-layers add-layer ../source/meta-openembedded/meta-oe/
    bitbake-layers add-layer ../source/meta-openembedded/meta-python/
    bitbake-layers add-layer ../source/meta-openembedded/meta-networking/
    bitbake-layers add-layer ../source/meta-openembedded/meta-multimedia/
    bitbake-layers add-layer ../source/meta-raspberrypi/
    bitbake-layers add-layer ../source/meta-video-streamer/
    ```
1. Setup build in  ```conf/local.conf```
    ```
    MACHINE = "raspberrypi4"
    MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += "kernel-modules"

    DISTRO_FEATURES_remove = "x11" 
    DISTRO_FEATURES_remove = "wayland"

    DISTRO_FEATURES += " bluetooth "
    DISTRO_FEATURES += " opengl "
    DISTRO_FEATURES += " opencdm "
    DISTRO_FEATURES += " provisionproxy "
    
    MACHINE_FEATURES_remove = "vc4graphics"
    ```
1. Start a build
    ```
    bitbake streamer-image
    ```
    
