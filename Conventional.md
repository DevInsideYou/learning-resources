Resource for https://www.youtube.com/watch?v=JlfCRlFHmd8

# Conventional installation instructions for Ubuntu

## [Node.js](https://nodejs.org)
Copied from [DevInsideYou/install-nodejs](https://github.com/DevInsideYou/install-nodejs):
``` bash
wget -q https://script.install.devinsideyou.com/nodejs
sudo chmod +x nodejs && ./nodejs
```

## [commitlint](https://github.com/conventional-changelog/commitlint)
```bash
sudo npm install -g @commitlint/cli
sudo npm install -g @commitlint/config-conventional
```

Feel free to use a target local to your project.
```bash
echo "module.exports = { extends: ['@commitlint/config-conventional'] }" > ~/.commitlintrc.js
```

## [commitizen](https://commitizen.github.io/cz-cli/)
```bash
sudo npm install -g commitizen
sudo npm install -g cz-conventional-changelog
```

Feel free to use a target local to your project.
```bash
echo '{ "path": "cz-conventional-changelog" }' > ~/.czrc
```

## [cz-emoji](https://github.com/ngryman/cz-emoji) (optional)
Note: this requires [changes to commitlint](https://github.com/ngryman/cz-emoji#commitlint).
```bash
sudo npm install -g cz-emoji
```

Replaces `cz-conventional-changelog`.
```bash
echo '{ "path": "cz-emoji" }' > ~/.czrc
```

Optionally use unicode instead of [gitmoji](https://gitmoji.dev/) by editing the `~/.czrc`:
```bash
{
  "path": "cz-emoji",
  "config": {
    "cz-emoji": {
      "symbol": true
    }
  }
}
```

## Automatically lint your commit messages
```bash
cd /path/to/my/repo

echo 'echo "$(cat $1)" | commitlint' > .git/hooks/commit-msg
chmod +x .git/hooks/commit-msg
```

## [standard-version](https://github.com/conventional-changelog/standard-version)
```bash
sudo npm install -g standard-version
```

## Version bumps for Scala SBT projects
Contents of `my-project/.versionrc.json`:
```bash
{
  "bumpFiles": [
    {
      "filename": "version.sbt",
      "updater": "standard-version-updater.js"
    }
  ]
}
```

Contents of `my-project/standard-version-updater.js`:
```bash
module.exports.readVersion = contents =>
  contents.match(/"(?<version>.*)"/).groups.version

module.exports.writeVersion = (_, version) =>
  `ThisBuild / version := "${version}"\n`
```
