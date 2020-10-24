DESCRIPTION = "Streamer image blueprint"
LICENSE = "MIT"

include recipes-core/images/core-image-minimal.bb

inherit distro_features_check features_check

DISTRO_FEATURES_remove = "\
    x11 \
    wayland \ 
    vulkan \
" 
DISTRO_FEATURES_append = "\ 
    ipv4 \
    ipv6 \
    bluetooth \
    wifi \
    nfs \
    smbfs\ 
    opengl\ 
"

IMAGE_FEATURES += "hwcodecs \
                   package-management \
                   ssh-server-dropbear \
"

REQUIRED_DISTRO_FEATURES = "opengl"
CONFLICT_DISTRO_FEATURES = "wayland x11"

IMAGE_INSTALL += "\
   kernel-modules \
   packagegroup-streamer \
"

# If WPE Framework is enabled as distro feature, remove the default packagegroup-core-boot and run with our own
IMAGE_INSTALL_append = "packagegroup-streamer-boot"
IMAGE_INSTALL_remove = "packagegroup-core-boot"

ENABLE_I2C = "1"
ENABLE_SPI_BUS = "1"
KERNEL_MODULE_AUTOLOAD_rpi += "i2c-dev i2c-bcm2708"
DISABLE_OVERSCAN = "1"

