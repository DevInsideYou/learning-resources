# Windows Subsystem for Linux (WSL) 2

## Windows Steps

1. [Optional] Check version
    1. Update Windows.
    2. Press `Win+R`.
    3. Check Windows version by typing `winver` and pressing `Enter`. You should see at least `Version 1909 (OS Build 18363.1049)`. If you don't see this just wing it by trying to enable WSL anyway (as described below).

2. Enable WSL
    1. Press `Win+R`.
    2. Type in `OptionalFeatures` and press `Enter`.
    3. Enable:
        1. `Windows Subsystem for Linux` for WSL1
        2. `Virtual Machine Platform` for WSL2 (you need both a and b)
        3. On Windows Pro Edition `Hyper-V` (Only required for WSL2)
    4. Press `OK`.
    5. Restart your machine.

3. Install a distribution
    1. Open the start menu by pressing the `Win` key.
    2. Type in `store` to search for the `Microsoft Store` application and open it.
    3. In the top right corner search for `WSL`.
    4. Click on (for example) `Ubuntu 20.04 LTS`.
    5. Click `Get` (if already installed the button will show `Launch`). Note: the button is buggy and might say `Launch` even if the distribution in question is not installed.

4. [Optional] Install a decent terminal (recommended: Windows Terminal)
    1. Open the start menu by pressing the `Win` key.
    2. Type in `store` to search for the `Microsoft Store` application and open it.
    3. In the top right corner search for `Windows Terminal`.
    4. Click `Get`.

5. Open Windows Terminal
    1. Press `Win+R`.
    2. Type in `wt` and press `Enter` (the `wt.exe` is in this directory: `%USERPROFILE%\AppData\Local\Microsoft\WindowsApps` which is on the `%PATH%`)

6. Changing install location of a WSL distribution (can be used for backups). The default location is: `%USERPROFILE%\AppData\Local\Packages`
    1. Open Windows Terminal as described above.
    2. List your distributions by typing `wsl -l -v`.
    3. Export your distribution to wherever you like and wait for it to finish the export:
        ```bash
        wsl --export DISTRIBUTION_FROM_STEP_2 DISTRIBUTION_FROM_STEP_2_backup
        ```
    4. You now have a file called `DISTRIBUTION_FROM_STEP_2_backup` that can be used as a backup
    5. Remove/unregister the distribution (you have a backup):
        ```bash
        wsl --unregister DISTRIBUTION_FROM_STEP_2
        ```
    6. Import your backup into a new location/distribution:
        ```bash
        wsl --import NEW_NAME path\to\new\location\NEW_NAME DISTRIBUTION_FROM_STEP_2_backup
        ```
        NEW_NAME can be the same as before but should not be if you want to install the same distribution multiple times. WSL differentiates distributions by name. This is also why the `Get` button in the Windows Store turns into a `Launch` button - it simply compares names.

7. Change version of a WSL distribution. Changing the version basically means converting from a regular file system to a virtual drive in case of going from WSL1 to WSL2 or the other way around in case of WSL2 to WSL1. This can either be done during the `import` step (see above) by adding the `--version 1` or `--version 2` flags respectively or simply by setting the version to the desired one by typing `wsl --set-version DISTRIBUTION_NAME 1` or `wsl --set-version DISTRIBUTION_NAME 2` but behind the scenes an `export` and a consequent `import` will happen for you, which is why it takes roughly the same amount of time.

8. Change name of a WSL distribution. Unfortunately there is no shortcut that will do this for you. You need to jump thorugh the `export` -> `unregister` -> `import` hoops as described above, which can be easily scripted.

9. [WSL`2` only] Free unused space by compressing the virtual hard drive. Similar to most databases, virtual hard drives don't free up the unused space after allocation. Note the size of the hard drive -> Copy over a large file -> Remove the file. Note the size of the hard drive. It didn't free the space of the removed large file.
    1. Press the `Win` key.
    2. Type in `powershell`.
    3. Right click on `Windows PowerShell` and click on "Run as administrator".
    4. Shutdown all wsl instances by typing `wsl --shutdown`.
    5. Optimize the virtual hard drive:
        ```bash
        Optimize-VHD -Path path\to\ext4.vhdx -Mode full
        ```

## Linux Steps

These steps assume `Ubuntu 20.04 LTS` which runs on WSL`2` but should work under other distributions as well.

1. Open Windows Terminal as described above.
2. List your distributions by typing `wsl -l -v`.
3. Connect to your distribution by typing `wsl -d Ubuntu-20.04` (replace `Ubuntu-20.04` with `DISTRIBUTION_FROM_STEP_2` if necessary) (the `-d` is only necessary if multiple distributions are installed; otherwise simply typing `wsl` should suffice).
4. From here basic linux knowledge is assumed and most steps are optional so feel free to pick and choose what you need.
5. Update your distribution (this never hurts) by typing in something similar to:
    ```bash
    sudo apt update
    sudo apt -y full-upgrade
    sudo apt -y autoremove
    ```
6. Make sure that the `/etc/wsl.conf` file looks like this:
    ```
    [user]
    default=your_user_name
    ```
7. You might be interesting in using the following as your starting directory (the example shown is for Windows Terminal):
    ```json
    "startingDirectory": "\\\\wsl$\\playground\\home\\your_user_name"
    ```
8. The `hostname` cannot be changed but you can configure your shell (the example shown is for `bash`) to simply display whatever you prefer. Open `.bashrc` and replace the `\h` (around line 60) with whatever you prefer.

    Before:
    ```bash
    if [ "$color_prompt" = yes ]; then
        PS1='${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '
    else
        PS1='${debian_chroot:+($debian_chroot)}\u@\h:\w\$ '
    fi
    ```
    After:
    ```bash
    if [ "$color_prompt" = yes ]; then
        PS1='${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@your_machine_name\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '
    else
        PS1='${debian_chroot:+($debian_chroot)}\u@your_machine_name:\w\$ '
    fi
    ```
9. Create a shortcut that will open your terminal (the example shown is for Windows Terminal) and automatically connect to your distribution:
    1. Right click on an empty space -> `New` -> `Shortcut`.
    2. Type in `wt` and press `Enter`.
    3. Type in `your_distribution_name` or whatever you prefer and press `Enter`.
    4. Right click on your shortcut -> `Properties`.
    5. Change the `Target` by adding `-p your_distribution_name`:

        Before:
        ```
        C:\Users\agilesteel\AppData\Local\Microsoft\WindowsApps\wt.exe
        ```
        After:
        ```
        C:\Users\agilesteel\AppData\Local\Microsoft\WindowsApps\wt.exe -p your_distribution_name
        ```
    6. Press `OK`.
10. Cache your ssh key with keychain:
    1. `sudo apt install -y keychain`
    2. put the following into your `~/.profile` (note the `-sh` and NOT`.sh`):
        ```bash
        keychain --nogui --quiet $HOME/.ssh/id_rsa
        source $HOME/.keychain/$(hostname)-sh
        ```
11. Install and configure an X Server (for GUI apps and clipboard sharing).
    1. There are multiple to choose from. I tried Xming and had no issues with it. Get it [here](https://sourceforge.net/projects/xming/files/latest/download) and install it by clicking `Next` a bunch of times. The default settings work just fine so there is no need to fiddle with them.
    2. During the last step of the installation wizard you will be offered to launch the server. Feel free to do so. The following program is executed behind the scenes for you:
        ```
        C:\Program Files (x86)\Xming\XLaunch.exe
        ```
        This program allows you to configure and more importantly to save the configuration at the last step of the configuration wizard. The configuration is an executable.
    3. The default configuration is fine except for one flag - `No Access Control`. Make sure to set it to true.
    4. Save the configuration in your startup directory so that it will be run on Windows startup and you can thus forget about it:
        1. Press `Win+R`.
        2. Type in `shell:startup` and press `Enter` (this is the startup directory).
12. Configure the X Client (your WSL distribution). Your distribution(s) (the client(s)) need(s) to send GUI information to the server. The server (Windows) ip is dynamic but at least it is kept for you in the `/etc/resolv.conf` file. Put the following into your `~/.profile`:
    ```bash
    export DISPLAY=$(awk '/nameserver / {print $2; exit}' /etc/resolv.conf 2>/dev/null):0
    export LIBGL_ALWAYS_INDIRECT=1
    ```
13. Configure neovim clipboard sharing:
    1. Install xclip: `sudo apt install -y xclip`
    2. Make sure that the `set clipboard=unnamedplus` neovim setting is enabled in `~/.config/nvim/init.vim` or similar.
    3. This together with the X Server will allow you to share the clipboard with Windows even in `NORMAL` mode.
14. [Not required when run from VS Code] Run Java server applications. WSL automatically forwards all ports to Windows. However it does not yet support `IPv6`. That said Java applications use `IPv6` by default. Use the following system property to force it to use `IPv4` instead:
    ```bash
    export     _JAVA_OPTIONS="-Djava.net.preferIPv4Stack=true"
    # or
    export JAVA_TOOL_OPTIONS="-Djava.net.preferIPv4Stack=true"
    ```

## Visual Studio Code Steps

1. The `%PATH%` (Windows) and `$PATH` (Linux) are mixed together so running `explorer.exe` will find the Windows explorer program and open it. The same goes for `code` which would run Visual Studio Code in Windows assuming you have it installed.
2. VS Code will notice that it is being called from WSL and will offer you to install the `Remote - WSL` extension. Do it. This will install the `server` part in Linux and the `client` part in Windows.
3. Some of your Windows VS Code extensions need to be installed on the `server` which can easily be done from the VS Code extensions page.
